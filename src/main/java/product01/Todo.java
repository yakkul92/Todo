package product01;

import java.util.*;
import java.io.*;

public class Todo{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        ArrayList<ToDo> list = new ArrayList<>();
        while(true){
          System.out.println("??�������͂��Ă��������B??");
          System.out.print("1/�o�^ 2/�d�v�x�ύX 3/�폜 4/�I��>");
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
              System.out.println("�A�v���P�[�V�������I�����܂��B");
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
          System.out.printf("%d�E�E�E%s%n",i,list.get(i).showStatus());
        }
    }
    
    static void addItem(ArrayList<ToDo> list,Scanner sc){
        System.out.println("�V�KToDo���쐬���܂��B");
        System.out.print("Todo���e����͂��Ă�������>>");
        String title=sc.next();
        System.out.print("�d�v�x��1~10(�ő�)�œ��͂��Ă�������>>");
        int importance = sc.nextInt();
        ToDo t = new ToDo(title,importance);
        list.add(t);
    }
    
    class ToDo{
        // �t�B�[���h
        String title;
        int importance;

        // �R���X�g���N�^
        ToDo(String title, int importance){
            this.title = title;
            this.importance = importance;
        }
        
        // �C���X�^���X���\�b�h
        String showStatus(){
            return String.format("%s/�d�v�x:%d", this.title, this.importance);
        }
        void changeImportance(int importance){
            this.importance = importance;
            System.out.println("�d�v�x��ύX���܂����B");
        }
    }