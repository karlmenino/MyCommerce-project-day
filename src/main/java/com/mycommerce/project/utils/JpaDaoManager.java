package com.mycommerce.project.utils;


import lombok.Getter;


import jakarta.persistence.*;


@Getter
public class JpaDaoManager {
    private static JpaDaoManager instance=null;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("commerce");
    private JpaDaoManager() {}

    public static JpaDaoManager getInstance() {
        if (instance == null)instance = new JpaDaoManager();
        return instance;
    }
    public static void stop() {
        instance.emf.close();
    }
}
