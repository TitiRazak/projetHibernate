package com.example.projethibernate.DAO;

import com.example.projethibernate.entity.Visiter;

import java.util.List;

public interface visiterDAO {

    void addVisiter(Visiter visiter);

    List<Visiter> getAllVisites();
}
