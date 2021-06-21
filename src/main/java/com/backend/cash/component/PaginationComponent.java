package com.backend.cash.component;

import com.backend.cash.constant.ConstantsPagination;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class PaginationComponent {
    public String changePaginationResponse(Page<?> page, Integer size){

        Gson gson = new Gson();
        JsonObject json = new JsonObject();

        json.add(ConstantsPagination.CONTENT, gson.toJsonTree(page.getContent()));

        json.addProperty(ConstantsPagination.PAGE, page.getNumber());
        json.addProperty(ConstantsPagination.SIZE, size);
        json.addProperty(ConstantsPagination.TOTAL_SIZE, page.getTotalElements());

        return gson.toJson(json);
    }
}
