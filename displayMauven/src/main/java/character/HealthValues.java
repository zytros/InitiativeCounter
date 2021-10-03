package character;

public class HealthValues {
    final static String healthy = "Healthy";// 100% - 81
    final static String slightlyWounded = "Slightly Wounded";//80 - 61
    final static String wounded = "Wounded";//60 - 41
    final static String heavily = "Heavily Wounded";//40 - 21
    final static String critical = "Critically Wounded";//20 - 1
    final static String unconcious = "Unconcious";//0

    public String getStatus(int maxHP, int HP){
        double p = (double) HP / (double) maxHP;
        if(between(1.0, 0.81, p)){
            return healthy;
        }else if (between(0.8, 0.61, p)){
            return slightlyWounded;
        }else if (between(0.6, 0.41, p)){
            return wounded;
        }else if (between(0.4, 0.21, p)){
            return heavily;
        }else if (between(0.2, 0.01, p)){
            return critical;
        }else {
            return unconcious;
        }
    }

    private static boolean between(double upper, double lower, double val){
        if(val <= upper && val >= lower){
            return true;
        }
        return false;
    }

}
