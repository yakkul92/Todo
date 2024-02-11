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
    static void sortList(ArrayList<ToDo> list){
        for(int i=0;i<list.size()-1;i++){
          for(int j=i+1;j<list.size();j++){
            if(list.get(i).importance < list.get(j).importance){
              ToDo temp = list.get(i);
              list.set(i,list.get(j));
              list.set(j,temp);
            }
          }
        }
    }
    static void displayList(ArrayList<ToDo> list){
        sortList(list);
        for(int i=0;i<list.size();i++){
          System.out.printf("%d・・・%s%n",i,list.get(i).showStatus());
        }
    }
    
    static void addItem(ArrayList<ToDo> list,Scanner sc){
        System.out.println("新規ToDoを作成します。");
        System.out.print("Todo内容を入力してください>>");
        String title=sc.next();
        System.out.print("重要度を1~10(最大)で入力してください>>");
        int importance = sc.nextInt();
        ToDo t = new ToDo(title,importance);
        list.add(t);
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