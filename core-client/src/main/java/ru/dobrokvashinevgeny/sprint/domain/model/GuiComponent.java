/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.domain.model;

import ru.dobrokvashinevgeny.sprint.services.BaseViewContainerController;

/**
 * Класс GuiComponent
 */
public abstract class GuiComponent extends Component {
	private int x;

	private int y;

	private String width;

	private String height;

	private String toolTip;

	private boolean visible;

	private boolean enabled;

	private int tabIndex;

	public GuiComponent(String name, ComponentType componentType) {
		super(name, componentType);
	}

	/**
	 * Возвращает
	 *
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * Устанавливает
	 *
	 * @param x - значение
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Возвращает
	 *
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 * Устанавливает
	 *
	 * @param y - значение
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Возвращает
	 *
	 * @return
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * Устанавливает
	 *
	 * @param width - значение
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * Возвращает
	 *
	 * @return
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * Устанавливает
	 *
	 * @param height - значение
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * Возвращает
	 *
	 * @return
	 */
	public String getToolTip() {
		return toolTip;
	}

	/**
	 * Устанавливает
	 *
	 * @param toolTip - значение
	 */
	public void setToolTip(String toolTip) {
		this.toolTip = toolTip;
	}

	/**
	 * Возвращает
	 *
	 * @return
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * Устанавливает
	 *
	 * @param visible - значение
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	/**
	 * Возвращает
	 *
	 * @return
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Устанавливает
	 *
	 * @param enabled - значение
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Возвращает
	 *
	 * @return
	 */
	public int getTabIndex() {
		return tabIndex;
	}

	/**
	 * Устанавливает
	 *
	 * @param tabIndex - значение
	 */
	public void setTabIndex(int tabIndex) {
		this.tabIndex = tabIndex;
	}

	public abstract void buildComponent();

	protected abstract void locateInOwnerController(BaseViewContainerController ownerController);

	protected void buildChildComponents() {
		/* in GuiComponent it is empty */
	}

	public boolean isContainer() {
		return false;
	}
}