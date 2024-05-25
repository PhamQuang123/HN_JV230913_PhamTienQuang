package ra.springmvc_hibernate_jpa_student.mapper;

public interface GenerricMapper <R,E,V>{
    /*
    * R: DTO request
    * E: entity
    * V: DTO reponse
    * */
    E mapperRequestToEntity(R r);
    V mapperEntityToReponse(E e);
}
