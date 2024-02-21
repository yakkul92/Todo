package product01;

import java.util.*;
import java.io.*;

public class Todo{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        File file = new File("todo.csv");

        // ArrayList<ToDo> list = new ArrayList<>();

        ArrayList<ToDo> list;
        if (file.exists()) {
          list = loadFile(file);          
        }else{
          list = new ArrayList<>();
        }
        if (list.size() == 0) {
          System.out.println("ToDoは1件もありません");
        }else{
          displayList(list);
        }

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
    
    static void updateItem(ArrayList<ToDo> list,Scanner sc){
        if(list.size() == 0){
          System.out.println("まだToDoがありません");
          return;
        }
        System.out.printf("重要度を変更します。番号を入力してください。0~%d>>",list.size()-1);
        int no = sc.nextInt();
        ToDo t = list.get(no);
        System.out.print("重要度を再設定してください>>");
        int importance=sc.nextInt();
        t.changeImportance(importance);
    }
    
    static void deleteItem(ArrayList<ToDo> list,Scanner sc){
        System.out.printf("Todoを削除します。番号を入力してください。0~%d>",list.size()-1);
        int no = sc.nextInt();
        list.remove(no);
        System.out.println("1件削除しました。");
    }

    static ArrayList<ToDo> loadFile(File file) throws Exception{
      ArrayList<ToDo> list = new FileInputStream(file);
      InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
      BufferedReader br = new BufferedReader(isr);

      String line:
      while((line = br.readLine()) != null){
        String[] values = line.split(",");
        String title = value[0];
        int importance = Integer.parseInt(values[1]);
        ToDo t = new ToDo(title, importance);
        list.add(t);
      }
      br.close();
      return list;
    }

    static void saveFile(File file,ArrayList<ToDo> List) throws Exception{
      FileOutputStream fos = new FileOutputStream(file);
      OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
      BufferedWriter bw = new BufferedWriter(osw);

      for(ToDo c :list){
        bw.write(c.toCSV());
        bw.newLine();
      }
      bw.close();
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
        String toCSV(){
          return String.format("%s,%d",this.title,this.importance);
        }
    }