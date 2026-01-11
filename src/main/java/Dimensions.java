import java.awt.*;

public class Dimensions {
    //frame config
    public final static Dimension GUI_Size = new Dimension(500,700);

    //banner config
    public final static Dimension banner_Size = new Dimension(GUI_Size.width,50);

    //task panel config
    public final static Dimension TASKPANEL_SIZE = new Dimension(GUI_Size.width-25, GUI_Size.height-160);

    //add task config
    public final static Dimension ADDTASKBUTTON_SIZE = new Dimension(GUI_Size.width,50);


    // Task component config
    public final static Dimension TASKFIELD_SIZE = new Dimension((int)(TASKPANEL_SIZE.width*0.78),50);
    public final static Dimension CHECKBOX_SIZE = new Dimension((int)(TASKFIELD_SIZE.width*0.05),50 );
    public final static Dimension DELETEBUTTON_SIZE = new Dimension((int)(TASKFIELD_SIZE.width*0.12),50);
}
