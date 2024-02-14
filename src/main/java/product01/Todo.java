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