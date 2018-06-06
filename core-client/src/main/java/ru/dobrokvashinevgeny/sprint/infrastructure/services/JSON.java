/*
 * Copyright (c) 2018 Evgeny Dobrokvashin, All Rights Reserved.
 */

package ru.dobrokvashinevgeny.sprint.infrastructure.services;

import jsinterop.annotations.*;

/**
 * Класс JSON
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class JSON {
	public static native String stringify(Object obj);

	public static native Object parse(String obj);
}