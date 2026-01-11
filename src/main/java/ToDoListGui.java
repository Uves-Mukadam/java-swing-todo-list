import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoListGui extends JFrame implements ActionListener {

    //taskpanel and taskcomponent panel
    JPanel TaskPanel , taskComponentPanel;
    public ToDoListGui() {
       super("To do list ");
       setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(Dimensions.GUI_Size);
        pack();

       setLocationRelativeTo(null);
       setResizable(false);
       setLayout(null);
       setVisible(true);
       addGuiComponents();
//       getContentPane().setBackground(Color.decode("#121212"));

    }
   public void addGuiComponents(){

        //creating a banner
        JLabel bannerLabel = new JLabel("TO DO LIST");
        bannerLabel.setBounds(
                (Dimensions.GUI_Size.width-bannerLabel.getPreferredSize().width)/2,
                15,
               Dimensions.banner_Size.width,
                Dimensions.banner_Size.height
        );



        // creating a taskpanel and taskcomponent panel such that task panel store taskcomponent panel
       TaskPanel = new JPanel();
       taskComponentPanel = new JPanel();
       taskComponentPanel.setLayout(new BoxLayout(taskComponentPanel,BoxLayout.Y_AXIS));
       TaskPanel.add(taskComponentPanel);

      JScrollPane scrollPane = new JScrollPane(TaskPanel);
     scrollPane.setBounds(5,60, Dimensions.TASKPANEL_SIZE.width, Dimensions.TASKPANEL_SIZE.height);
     scrollPane.setMaximumSize(Dimensions.TASKPANEL_SIZE);
     scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
     scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


     JScrollBar verticalScroll = scrollPane.getVerticalScrollBar();
     verticalScroll.setUnitIncrement(20);


     //creating ADD  task button
       JButton addTaskButton = new JButton("Add Task");
       addTaskButton.setBounds(-5, Dimensions.GUI_Size.height-88,
               Dimensions.ADDTASKBUTTON_SIZE.width, Dimensions.ADDTASKBUTTON_SIZE.height);
       addTaskButton.addActionListener(this);


     // add to frame
     this.getContentPane().add(scrollPane);
     this.getContentPane().add(bannerLabel);
     this.getContentPane().add(addTaskButton);
     TaskPanel.setBackground(Color.decode("#1F1F1F"));
   }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equalsIgnoreCase("Add Task")) {

            TaskComponent taskComponent = new TaskComponent(taskComponentPanel);
            taskComponentPanel.add(taskComponent).setBackground(Color.decode("#A6A6A6"));

            // making the task field request focus after creation
            taskComponent.getTaskField().requestFocus();
            repaint();
            revalidate();

        }
    }
}
