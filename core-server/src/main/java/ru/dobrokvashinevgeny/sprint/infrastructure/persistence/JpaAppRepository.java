/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.persistence;

import ru.dobrokvashinevgeny.sprint.services.AppRepository;

import javax.persistence.*;

/**
 * Класс JpaAppRepository
 */
public class JpaAppRepository implements AppRepository {
	@PersistenceContext(unitName = "ru.dobrokvashinevgeny.sprint.jpa")
	private EntityManager entityManager;

	@Override
	public void getApplicationByCode() {

	}

	@Override
	public void saveApplication() {
//		entityManager.persist();
		entityManager.flush();
	}
}