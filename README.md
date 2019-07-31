TODOList
====
# 1. 概要
今回は某インターンの課題としてTODOリストを作成した.<br>
TODOリストの主な仕様としては,<br>
TODOリストの追加(追加時間,TODO名,〆切日をデータベースに保存する)<br>
TODOリストの編集(データベース上のTODO名と〆切日の変更)<br>
TODOリストの検索(データベース上のTODO名の検索)<br>
である.
また開発環境はEclipse,サーバーはAWSを使用した.
# 2. 設計・構成についての説明
主にこのWebアプリは3つの画面から構成される.<br>
1.TODO追加画面<br>
2.TODO編集画面<br>
3.TODO検索画面<br>
である.先ずは1.のTODO追加画面の設計について説明する.<br>
## 2.1.TODO追加画面
![suteru_fay](https://user-images.githubusercontent.com/52820882/62184351-ae2b8780-b398-11e9-8c2a-b372d3467e81.png)
TODOの追加については画面上に入力されたTODO名と締め切り時間,またTODOが未完了である事を認識させるため数字デフォルトで0を,ボタンの実装に必要なデフォルトの値"red"を追加ボタンを押すとサーバーに転送する.以下に追加の際のサンプルプログラムを示す.ここでのnとはEmployeeクラスのインスタンス,empRepositoryとはEmployeeRepositoryクラスのインスタンスのことである.
```java:HelloController.java
                n.setTodoname(text1);//toDO名の追加
		n.setUntildate(Date);//締め切り時間の追加
		n.setColor("red");//ボタンのための完了フラグの追加
		Long i =(long) 0;
		n.setComplete(i);//完了フラグの追加
		LocalDate d = LocalDate.now();
		DateTimeFormatter df1 = 
				DateTimeFormatter.ofPattern("yyyy-MM-dd");
		n.setCreatedate(df1.format(d));//追加した現在の時間の追加
		empRepository.save(n);
```
ボタンのための完了フラグを別に管理した理由は,今回は完了・未完了をボタンで切り替えることが要求仕様であったためである.もっと良い方法があったと思うが実装の方法がわからなかったので管理を完了フラグと別にした.完了ボタンを押した時の挙動としては,完了状態だとボタンの文字を完了,背景を青に未完了状態だとボタンの文字を未完了,背景を赤にする.プログラムは以下の通りである.
```java:HelloController.java
    	if(empRepository.findComp(colorid).equals("blue")) {
    	empRepository.update2(0,"red",colorid);
    	}else {
    	empRepository.update2(1,"blue",colorid);
    	}
    	List<Employee> emplist=empRepository.findAll(new Sort(Sort.Direction.DESC,"id"));
        model.addAttribute("employeelist", emplist);
	return "index";
```
```java:EmployeeRepository.java
    	@Modifying
	@Transactional
	@Query(value = "update test3 t set"
			+ " t.complete = :complete,"
			+ " t.color = :color"
			+ " where t.listno = :listno", nativeQuery = true)
	public int update2(
		@Param("complete") int complete,
    		@Param("color") String color,
    		@Param("listno") int listno);
```
次に編集ボタンの説明をする.編集ボタンについてはTODOのidで編集すべきTODOを認識して編集する.HelloControllerクラスのchangeメソッドがそれに当たる.
## 2.2.TODO編集画面
![suteru_fay](https://user-images.githubusercontent.com/52820882/62186244-817b6e00-b3a0-11e9-9537-f6d2c4c8a5e7.png)
編集画面についてはTODO追加画面,または検索画面でのボタンが押されたTODOのIDを取得して,IDに応じたTODO名と締め切り時間の表示をする.
編集画面で編集事項が入力されボタンを押されるとTODOがアップデートされる.HelloControllerクラスのchメソッドがそれに当たる.
## 2.3.TODO検索画面
検索画面においては,未完了状態のTODOしか検索できない仕様である.<br>
検索については部分一致のものを検索するのが要求仕様であったため,クエリを以下のようにLIKE詞で修飾した.<br>
```mysql:sample.sql
select * from test3 where todoname like ?1% AND complete=0
```
検索結果で出てくる編集ボタンや完了ボタンの挙動については,2.1節のTODO追加画面と同じである.
![suteru_fay](https://user-images.githubusercontent.com/52820882/62186244-817b6e00-b3a0-11e9-9537-f6d2c4c8a5e7.png),
