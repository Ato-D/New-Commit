package com.example.Centrifugo.utility;


/**
 * Created this class to be model the Java Page class to be used when pagination manually
 * @author Derrick Donkoh.
 * @createdAt 24th April 2024
 */

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Custom class to represent pagination object used for handling paginated data.
 *
 * @author Derrick DOnkoh.
 * @createdAt 24th April 2024
 */
public class Pagination {

    private final List content;
    private final int size;
    private final int page;
    private final int totalElements;
    private final Sort sort;

    public Pagination(List content, Pageable pageable, int totalElements) {
        this.content = content == null ? new ArrayList() : content;
        this.size = (pageable != null && pageable.isPaged() && pageable.getPageSize() >= 0)
                ? pageable.getPageSize() : 0;
        this.page = (pageable != null && pageable.isPaged() && pageable.getPageNumber() >= 0)
                ? pageable.getPageNumber() : 0;
        this.sort = pageable != null && pageable.isPaged()
                ? pageable.getSort() : null;
        this.totalElements = (pageable != null && totalElements >= 0) ? totalElements : 0;

    }

    public int getPage() {
        return this.page;
    }

    public int getTotalPages() {
        if (this .totalElements == 0 || this.size == 0) return 0;
        return (int) Math.ceil(this.totalElements/Math.ceil(this.size));
    }

    public int getTotalElements() {
        return this.totalElements;
    }

    public int getNumber() {
        return this.page;
    }

    public int getSize() {
        return this.size;
    }

    public int getNumberOfElements() {
        return this.content.size();
    }

    public List getContent() {
        return content;
    }

    public boolean hasContent() {
        return !content.isEmpty();
    }

    public Sort getSort() {
        return this.sort;
    }

    public boolean isFirst() {
        return this.page == 0;
    }

    public boolean isLast() {
        return this.page == getTotalPages();
    }

    public boolean hasNext() {
        return !isLast();
    }

    public boolean hasPrevious() {
        return !isFirst();
    }

}
