package view;

import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Sets up actions for non-tool buttons.
 * 
 * @author Gehry Guest
 * @version 2.0
 */
public final class ThicknessChanges implements ChangeListener {
    
    /** Integer value to hold thickness of drawings. */
    private static int myThicknessValue;
    
    /** The slider for thickness of drawings. */
    private JSlider myThicknessSlider;
    
    /**
     * creates the slider for the thickness menu.
     * 
     * @return JSlider with ticks and numbers.
     */
    public JSlider createSlider() {
        final int increment = 5;
           
        final int maxNumber = 15;

        myThicknessSlider = new JSlider(SwingConstants.HORIZONTAL, 0, maxNumber, increment);
           
        myThicknessSlider.setMajorTickSpacing(increment);
           
        myThicknessSlider.setMinorTickSpacing(1);
           
        myThicknessSlider.setPaintLabels(true);
           
        myThicknessSlider.setPaintTicks(true);
           
        myThicknessSlider.addChangeListener(this);
           
        myThicknessValue = increment;
        
        return myThicknessSlider;
    }

   /**
    * sets the integer value for thickness.
    * 
    * @param theThicknessValue integer for thickness.
    */
    public void setMyThicknessValue(final int theThicknessValue) {

        myThicknessValue = theThicknessValue;
    }
       
   /**
    * returns a integer value.
    * 
    * @return myThicknessValue integer from slider.
    */
    public int getMyThicknessValue() {

        return myThicknessValue;
    }
    
    /** {@inheritDoc} */
    @Override
    public void stateChanged(final ChangeEvent theEvent) {

        setMyThicknessValue(myThicknessSlider.getValue());
    }
}

