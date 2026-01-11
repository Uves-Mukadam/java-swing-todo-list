import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskComponent extends JPanel implements ActionListener{
    private JCheckBox checkBox;
    private JTextPane taskField;
    private JButton deleteButton ;

    public JTextPane getTaskField() {
        return taskField;
    }
    // this panel is used so that we can make updates to the task component panel when deleting tasks
    private JPanel parentPanel ;

    public TaskComponent(JPanel parentPanel){
        this.parentPanel=parentPanel;

        //taskfield
        taskField = new JTextPane();
        taskField.setPreferredSize(Dimensions.TASKFIELD_SIZE);
        taskField.setContentType("text/html");
//        taskField.setBackground(Color.decode("#BFBFBF"));

        //checkbox
        checkBox = new JCheckBox();
        checkBox.setPreferredSize(Dimensions.CHECKBOX_SIZE);
        checkBox.addActionListener(this);
//        checkBox.setBackground(Color.decode("#BFBFBF"));

        //deleteButton
        deleteButton = new JButton("x");
        deleteButton.setPreferredSize(Dimensions.DELETEBUTTON_SIZE);
        deleteButton.addActionListener(this);
//        deleteButton.setBackground(Color.decode("#BFBFBF"));


    // add this to task Component
      add(checkBox);
      add(taskField);
      add(deleteButton);

    }


    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getActionCommand().equalsIgnoreCase("x")){

            parentPanel.remove(this);
            parentPanel.repaint();
            parentPanel.revalidate();
        }
        if(checkBox.isSelected()){
            String text = taskField.getText().replaceAll("<[^>]*>","");

            taskField.setText("<html><s>"+text+"</s></html>");
        } else if (!checkBox.isSelected()) {
            String text = taskField.getText().replaceAll("<[^>]*>","");
            taskField.setText(text);

        }
    }
}
