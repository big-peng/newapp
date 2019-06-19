package com.hzaihua.jfoenix.controller.measure;

import com.hzaihua.jfoenix.controller.TCPLink.SendingInstruct;
import com.hzaihua.jfoenix.controller.TCPLink.SendingThread;
import com.hzaihua.jfoenix.entity.Lppp;
import com.hzaihua.jfoenix.service.LpppService;
import com.hzaihua.jfoenix.util.BeanFactoryUtil;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTimePicker;
import io.datafx.controller.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.text.Text;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@ViewController(value = "/views/fxml/measure/notes.fxml")
public class ReadNotesController {
    @FXML private CheckBox lp; //lp数据
    @FXML private DatePicker startDate;  //开始日期
    @FXML private JFXTimePicker startTime;  //开始时间
    @FXML private DatePicker endDate; //结束日期
    @FXML private JFXTimePicker endTime; //结束时间

    @FXML private JFXButton commitNotes;
    @FXML private Text actiontarget;

    public static String lpstartTime;
    public static String lpendTime;
    public static Lppp lppp = new Lppp();
    LpppService lpppService = BeanFactoryUtil.getApplicationContext().getBean(LpppService.class);

    @PostConstruct
    public void init(){

        commitNotes.setOnAction(event -> {
            change();
            if(lp.isSelected() == false){
                actiontarget.setText("未选择查询的选项");
            }else if(lpstartTime == null && lpendTime == null){
                actiontarget.setText("未选择时间");
            } else {
                /*SendingInstruct sendingInstruct = new SendingInstruct();
                SendingThread.instruct = sendingInstruct.instruct131();
                SendingThread sendingThread = new SendingThread(SendingThread.socket);
                sendingThread.SendingSock(SendingThread.instruct);
                try {
                    sendingThread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                    lpppService.savelppp(lppp);
                    /*SendingInstruct sendingInstruct1 = new SendingInstruct();
                    SendingThread.instruct = sendingInstruct1.instruct131Next();
                    SendingThread sendingThread1 = new SendingThread(SendingThread.socket);
                    sendingThread1.SendingSock(sendingThread1.instruct);*/
            }
        });
    }


    private void change(){
        startTime.set24HourView(true);
        endTime.set24HourView(true);
        StringBuffer sub = new StringBuffer();
        sub.append(startDate.getValue()).append(" ").append(startTime.getValue()).append(":00");
        StringBuffer subb = new StringBuffer();
        subb.append(endDate.getValue()).append(" ").append(endTime.getValue()).append(":00");
        lpstartTime = sub.toString().replace(" ","");
        lpstartTime = lpstartTime.replace("-","");
        lpstartTime = lpstartTime.replace(":","");
        lpendTime = subb.toString().replace(" ","");
        lpendTime = lpendTime.replace("-","");
        lpendTime = lpendTime.replace(":","");
        System.out.println(lpstartTime);
        System.out.println(lpendTime);
    }
}

