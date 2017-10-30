package com.tarnum.spring.Service;

import com.tarnum.spring.Dto.IdeaDTO;

import java.util.List;

public interface IdeasService {

    int add(IdeaDTO idea);

    int update(IdeaDTO idea);

    int delete(int id);

    IdeaDTO get(int id);

    List<IdeaDTO> list();
}
