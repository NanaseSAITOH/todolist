TODOList
====
# 概要
今回は某インターンの課題としてTODOリストを作成した.<br>
TODOリストの主な仕様としては,<br>
TODOリストの追加(追加時間,TODO名,〆切日をデータベースに保存する)<br>
TODOリストの編集(データベース上のTODO名と〆切日の変更)<br>
TODOリストの検索(データベース上のTODO名の検索)<br>
である.
また開発環境はEclipse,サーバーはAWSを使用した.
# 設計・構成についての説明
主にこのWebアプリは3つの画面から構成される.<br>
1.TODO追加画面<br>
2.TODO編集画面<br>
3.TODO検索画面<br>
である.先ずは1.のTODO追加画面の設計について説明する.<br>
![suteru_fay](https://user-images.githubusercontent.com/52820882/62184351-ae2b8780-b398-11e9-8c2a-b372d3467e81.png)
TODOの追加については画面上に入力されたTODO名と締め切り時間,またTODOが未完了である事を認識させるため数字デフォルトで0を,ボタンの実装に必要なデフォルトの値"red"を追加ボタンを押すとサーバーに転送する.以下に追加の際のサンプルプログラムを示す.
```java:push.java
    n.setTodoname(text1);
		n.setUntildate(Date);
		n.setColor("red");
		Long i =(long) 0;
		n.setComplete(i);
		LocalDate d = LocalDate.now();
		DateTimeFormatter df1 = 
				DateTimeFormatter.ofPattern("yyyy-MM-dd");
		n.setCreatedate(df1.format(d));
		empRepository.save(n);
```
