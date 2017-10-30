package com.tarnum.spring.Service;

import com.tarnum.spring.Dto.IdeaDTO;
import com.tarnum.spring.Dao.IdeasDAO;
import com.tarnum.spring.Model.Idea;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class IdeasServiceImpl implements IdeasService{
    @Autowired
    IdeasDAO dao;

    @Override
    public int add(IdeaDTO idea) {
        return dao.add(convert(idea));
    }

    @Override
    public int update(IdeaDTO idea) {
        return dao.update(convert(idea));
    }

    @Override
    public int delete(int id) {
        return dao.delete(id);
    }

    @Override
    public IdeaDTO get(int id) {
        return convert(dao.get(id));
    }

    @Override
    public List<IdeaDTO> list() {
        return dao.list().stream().map(IdeasServiceImpl::convert).collect(Collectors.toList());
    }

    private static Idea convert(IdeaDTO idea) {
        Idea modelIdea = new Idea();
        modelIdea.setId(idea.getId());
        modelIdea.setContent(idea.getContent());
        modelIdea.setCaption(idea.getCaption());
        modelIdea.setLikes(idea.getLikes());
        modelIdea.setDislikes(idea.getDislikes());
        return modelIdea;
    }

    private static IdeaDTO convert(Idea idea) {
        IdeaDTO ideaDTO = new IdeaDTO();
        ideaDTO.setId(idea.getId());
        ideaDTO.setContent(idea.getContent());
        ideaDTO.setCaption(idea.getCaption());
        ideaDTO.setLikes(idea.getLikes());
        ideaDTO.setDislikes(idea.getDislikes());
        return ideaDTO;
    }
}
