package com.backend.bakckend.designpattern.simple;

import java.awt.*;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextListener;


interface Mediator {
    void createColleagues();

    void colleagueChanged();
}

interface Colleague {
    void setMediator(Mediator mediator);

    void setColleagueEnabled(boolean enabled);
}

class ColleagueButton extends java.awt.Button implements Colleague {
    private Mediator mediator;

    public ColleagueButton(String caption) {
        super(caption);
    }

    public void setMediator(Mediator mediator) {          // Mediator를 저장
        this.mediator = mediator;
    }

    public void setColleagueEnabled(boolean enabled) {    // Mediator로부터 Colleague의 enable/disable을 요청받음
        setEnabled(enabled);
    }
}

class ColleagueTextField extends TextField implements Colleague, TextListener {
    private Mediator mediator;

    public ColleagueTextField(String text, int columns) {
        super(text, columns);
    }

    public void setMediator(Mediator mediator) {          // Mediator를 저장
        this.mediator = mediator;
    }

    public void setColleagueEnabled(boolean enabled) {    // Colleague의 enable/disable을 직접 처리
        setEnabled(enabled);
        setBackground(enabled ? java.awt.Color.white : java.awt.Color.lightGray);
    }

    public void textValueChanged(java.awt.event.TextEvent e) {
        mediator.colleagueChanged();
    }
}

class ColleagueCheckbox extends Checkbox implements Colleague, java.awt.event.ItemListener {
    private Mediator mediator;

    public ColleagueCheckbox(String caption, CheckboxGroup group, boolean state) {
        super(caption, group, state);
    }

    public void setMediator(Mediator mediator) {          // Mediator를 저장
        this.mediator = mediator;
    }

    public void setColleagueEnabled(boolean enabled) {    // Colleague의 enable/disable을 직접 처리
        setEnabled(enabled);
    }

    public void itemStateChanged(java.awt.event.ItemEvent e) {
        mediator.colleagueChanged();
    }
}

class ColleagueLabel extends java.awt.Label implements Colleague {
    private Mediator mediator;

    public ColleagueLabel(String caption, int alignment) {
        super(caption, alignment);
    }

    public void setMediator(Mediator mediator) {          // Mediator를 저장
        this.mediator = mediator;
    }

    public void setColleagueEnabled(boolean enabled) {    // Colleague의 enable/disable을 직접 처리
        // do nothing
    }
}

class LoginFrame extends Frame implements ActionListener, Mediator {
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    public LoginFrame(String title) {
        super(title);
        setBackground(java.awt.Color.lightGray);
        setLayout(new java.awt.GridLayout(4, 2));
        createColleagues();
        add(checkGuest);
        add(checkLogin);
        add(new Label("Username:"));
        add(textUser);
        add(new Label("Password:"));
        add(textPass);
        add(buttonOk);
        add(buttonCancel);
        colleagueChanged(checkGuest);
        pack();
        show();
    }


    public void createColleagues() {
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", g, true);
        checkLogin = new ColleagueCheckbox("Login", g, false);
        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        textPass.setEchoChar('*');
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");
        // Mediator의 설정
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);
        // Listener
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);

    }

    @Override
    public void colleagueChanged() {
        if (checkGuest.getState()) {                // Guest mode
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(true);
        } else {                                    // Login mode
            textUser.setColleagueEnabled(true);
            userpassChanged();
        }
    }

    public void colleagueChanged(Colleague c) {
        if (c == checkGuest || c == checkLogin) {
            if (checkGuest.getState()) {
                textUser.setColleagueEnabled(false);
                textPass.setColleagueEnabled(false);
                buttonOk.setColleagueEnabled(true);
            } else {
                textUser.setColleagueEnabled(true);
                userpassChanged();
            }
        } else if (c == textUser || c == textPass) {
            userpassChanged();
        } else {
            System.out.println("colleagueChanged:unknown colleague = " + c);
        }
    }

    void userpassChanged() {
        if (textUser.getText().length() > 0) {
            textPass.setColleagueEnabled(true);
            if (textPass.getText().length() > 0) {
                buttonOk.setColleagueEnabled(true);
            } else {
                buttonOk.setColleagueEnabled(false);
            }
        } else {
            textPass.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(false);
        }
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("" + e.toString());
        System.exit(0);
    }



}

public class MediatorTest {
    public static void main(String[] args) {
        new LoginFrame("Mediator Sample");
    }

}




