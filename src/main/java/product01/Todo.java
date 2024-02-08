package product01;

import java.util.*;
import java.io.*;

public class Todo{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        ArrayList<ToDo> list = new ArrayList<>();
        while(true){
          System.out.println("??操作を入力してください。??");
          System.out.print("1/登録 2/重要度変更 3/削除 4/終了>");
          int select = sc.nextInt();
          switch(select){
            case 1:
              addItem(list,sc);
              break;
            case 2:
              updateItem(list,sc);
              break;
            case 3:
              deleteItem(list,sc);
              break;
            default:
              System.out.println("アプリケーションを終了します。");
              return;
          }
          displayList(list);
        }
    }
  }
  class ToDo{
    // フィールド
    String title;
    int importance;

    // コンストラクタ
    ToDo(String title, int importance){
        this.title = title;
        this.importance = importance;
    }
    
    // インスタンスメソッド
    String showStatus(){
        return String.format("%s/重要度:%d", this.title, this.importance);
    }
    void changeImportance(int importance){
        this.importance = importance;
        System.out.println("重要度を変更しました。");
    }
  }