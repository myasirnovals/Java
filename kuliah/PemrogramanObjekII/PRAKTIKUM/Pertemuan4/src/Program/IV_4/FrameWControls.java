package Program.IV_4;

import java.awt.*;

public class FrameWControls extends Frame {
    public FrameWControls() {
    }

    public static void main(String args[]) {
        FrameWControls fwc = new FrameWControls();
        fwc.setLayout(new FlowLayout()); //more on this later
        fwc.setSize(600, 600);
        fwc.add(new Button("Test Me!"));
        fwc.add(new Label("Labe"));
        fwc.add(new TextField());
        CheckboxGroup cbg = new CheckboxGroup();
        fwc.add(new Checkbox("chk1", cbg, true));
        fwc.add(new Checkbox("chk2", cbg, false));
        fwc.add(new Checkbox("chk3", cbg, false));
        List list = new List(3, false);
        list.add("MTV");
        list.add("V");
        fwc.add(list);
        Choice chooser = new Choice();
        chooser.add("Avril");
        chooser.add("Monica");
        chooser.add("Britney");
        fwc.add(chooser);
        fwc.add(new Scrollbar());
        fwc.setVisible(true);
    }
}
