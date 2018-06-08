package ru.dobrokvashinevgeny.sprint.domain.model;

/**
 * Класс ComponentType
 */
public enum ComponentType {
	Button("button"),
	BorderLayout("borderLayout");

	private String typeId;

	ComponentType(String typeId) {
		this.typeId = typeId;
	}

	/**
	 * Возвращает
	 *
	 * @return
	 */
	public String getTypeId() {
		return typeId;
	}
}