package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private boolean completed;

    // �R���X�g���N�^�A�Q�b�^�[�A�Z�b�^�[�Ȃǂ�ǉ�

    // �ȗ�
}
