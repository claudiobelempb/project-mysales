export type PageResponse<T> = {
  content: T[];
  pageable: PagePageable;
  last: boolean;
  totalPages: number;
  totalElements: number;
  first: boolean;
  size: number;
  number: number;
  sort: PageSort;
  numberOfElements: number;
  empty: boolean;
};

export type PagePageable = {
  pageNumber: number;
  pageSize: number;
  sort: PageSort;
  offset: number;
  paged: boolean;
  unpaged: boolean;
};

export type PageSort = {
  sorted: boolean;
  empty: boolean;
  unsorted: boolean;
};
