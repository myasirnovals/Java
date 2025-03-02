package repository;

import entity.Todolist;

public interface TodolistRepository {
    Todolist[] getAll();

    void add(Todolist todolist);

    void remove(Integer number);
}
