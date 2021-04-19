package org.ok.bella.ui.entities;

import org.ok.bella.model.Entity;

import java.util.List;

public interface EntitiesDataProvider<E extends Entity> {

    long count();

    List<E> getItems();
}
