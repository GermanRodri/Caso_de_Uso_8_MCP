package com.uptc.frw.mcprestaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the relationship between Sales and Menus
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record SaleMenu(
    @JsonProperty("idMenu") Long idMenu,
    @JsonProperty("idSale") Long idSale,
    @JsonProperty("quantity") Integer quantity
) {
}
