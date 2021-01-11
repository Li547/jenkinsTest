package com.lgs.service.impl;

import com.lgs.dao.InfoMapper;
import com.lgs.entity.Info;
import com.lgs.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    private InfoMapper infoMapper;
    @Override
    public List<Info> getAll() {
        return infoMapper.selectAll();
    }

    @Override
    public int add(Info info) {
        return infoMapper.insert(info);
    }

    @Override
    public Info findByid(Integer id) {
        return infoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(Info info) {
        return infoMapper.updateByPrimaryKey(info);
    }

    @Override
    public int delete(Integer id) {
        return infoMapper.deleteByPrimaryKey(id);
    }
}
