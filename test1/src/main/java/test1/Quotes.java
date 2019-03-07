package test1;

/* http://apilayer.net/api/live?access_key=07b88071071212c8e286cf29cd653547&currencies=KWD,JPY,PHP&source=USD&format=2 */

public class Quotes {


  private double usdphp;
  private double usdjpy;
  private double usdkwd;

  public double getUsdjpy() {
    return usdjpy;
  }

  public double getUsdkwd() {
    return usdkwd;
  }

  public double getUsdphp() {
    return usdphp;
  }

  public void setUsdjpy(double usdjpy) {
    this.usdjpy = usdjpy;
  }

  public void setUsdkwd(double usdkwd) {
    this.usdkwd = usdkwd;
  }

  public void setUsdphp(double usdphp) {
    this.usdphp = usdphp;
  }
}
