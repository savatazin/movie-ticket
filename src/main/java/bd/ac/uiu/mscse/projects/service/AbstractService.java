package bd.ac.uiu.mscse.projects.service;


import bd.ac.uiu.mscse.projects.model.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class AbstractService<T extends Base, R extends JpaRepository<T, Integer>> {

  @Autowired
  protected R repository;

  public AbstractService(R repository) {
    this.repository = repository;
  }

  public T get(final Integer id) {
    return repository.getOne(id);
  }

  public List<T> getAll() {
    return repository.findAll();
  }

  public Integer save(T value) {
    return repository.save(value).getId();
  }

  public Integer update(T value) {
    return repository.save(value).getId();
  }

  public void delete(Integer id) {
    repository.delete(id);
  }
}
