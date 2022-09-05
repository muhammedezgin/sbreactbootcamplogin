package com.example.sbreactbootcamp.users.service;

public interface IRoleService<T> extends IService<T> {

	T findByName(String name);
}
