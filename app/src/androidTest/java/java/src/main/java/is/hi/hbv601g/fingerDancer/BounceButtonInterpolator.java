package java.src.main.java.is.hi.hbv601g.fingerDancer;

public class BounceButtonInterpolator implements android.view.animation.Interpolator {
    private double mAmplitude = 1;
    private double mFrequency  = 10;

   public BounceButtonInterpolator(double amplitude , double frequency){
        mAmplitude = amplitude;
        mFrequency = frequency;
   }

    @Override
    public float getInterpolation(float time) {
        return (float) (-1 * Math.pow(Math.E, -time/ mAmplitude) *
                Math.cos(mFrequency * time) +1);
    }
}
