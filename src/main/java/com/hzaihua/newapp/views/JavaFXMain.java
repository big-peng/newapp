package com.hzaihua.newapp.views;

import de.felixroske.jfxsupport.AbstractFxmlView;
import de.felixroske.jfxsupport.FXMLView;

//fxml文件必须要放到resources中，而且路径必须是绝对路径
//否则就会报找不到文件，无法加载的错误
@FXMLView( value = "/views/login.fxml")
public class JavaFXMain extends AbstractFxmlView {
}
