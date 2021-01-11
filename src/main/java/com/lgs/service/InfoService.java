package com.lgs.service;

import com.lgs.entity.Info;

import java.util.List;

public interface InfoService {
    List<Info> getAll();
    int add(Info info);
    Info findByid(Integer id);
    int update(Info info);
    int delete(Integer id);
}
