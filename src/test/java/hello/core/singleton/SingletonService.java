package hello.core.singleton;

public class SingletonService {

    // 자기자신을 내부에 private으로 하나 갖고있는데 static으로 갖고있음 => class 레벨에 올라가기때문에 딱 하나만 존재한다.
    private static final SingletonService instance = new SingletonService();

    //이 객체 인스턴스가 필요하면 getInstance() 메서드를 통해서만 조회할 수 있다. 이 메서드를 호출하면 항상 같은 인스턴스를 반환한다.
    public static SingletonService getInstance(){
        return instance;
    }

    // private을 써서 외부에서 추가 생성을 막아버림
    private SingletonService(){ }

    public void logic(){
        System.out.println("싱글톤 객체 로직을 호출");
    }

}
