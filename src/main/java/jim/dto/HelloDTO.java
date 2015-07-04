package jim.dto;

import jim.entity.HelloEntity;

public class HelloDTO {

    private String myHello;

    public HelloDTO() {

    }

    public String getMyHello() {
        return myHello;
    }

    public void setMyHello(String myHello) {
        this.myHello = myHello;
    }

    static public HelloDTO Build(HelloEntity entity) {
        HelloDTO dto = new HelloDTO();
        dto.setMyHello(entity.getMyHello());

        return dto;
    }
}
