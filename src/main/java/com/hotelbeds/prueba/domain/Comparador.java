package com.hotelbeds.prueba.domain;

import java.util.Comparator;

public class Comparador implements Comparator<DescuentoPedido> {
	  @Override
	  public int compare(DescuentoPedido p1, DescuentoPedido p2) {
	    return  p1.getValorPedido().compareTo(p2.getValorPedido());
	  }
	}
