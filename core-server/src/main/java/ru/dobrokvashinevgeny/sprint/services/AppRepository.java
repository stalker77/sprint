package ru.dobrokvashinevgeny.sprint.services;

/**
 * Класс AppRepository
 */
public interface AppRepository {
	void getApplicationByCode();

	void saveApplication();
}