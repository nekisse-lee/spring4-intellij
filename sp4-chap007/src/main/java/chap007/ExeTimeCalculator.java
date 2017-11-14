package chap007;

public class ExeTimeCalculator implements Calculator {


/*     기존 ImpeCalculator클래스나 RecCalculator 클래스를 수정하지 않고
          생성자를 통해 다른 Calculator 객체를 전달받아 delegate 필드에 할당한 뒤 18 행의 factorial()메서드에서 delegate.factorial()메서드를 실행한다
        그리고 delegate.factorial()코드 전후의 시간을 구해 시간차이를 출력한다*/
    private Calculator delegate;

    public ExeTimeCalculator(Calculator delegate) {
        this.delegate = delegate;
    }

    @Override
    public long factorial(long num) {
        long start = System.nanoTime();
        long result = delegate.factorial(num);
        long end = System.nanoTime();
        System.out.printf("%s.factorial(%d) 실행 시간 = %d\n",
                delegate.getClass().getSimpleName(),
                num, (end - start));
        return result;
    }

}

