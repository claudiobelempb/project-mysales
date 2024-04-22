import { ProductResponse } from './ProductResponse';

export type ProductPageResponse = {
  content: ProductResponse[];
  pageable: ProductPagePageable;
  last: boolean;
  totalPages: number;
  totalElements: number;
  first: boolean;
  size: number;
  number: number;
  sort: ProductPageSort;
  numberOfElements: number;
  empty: boolean;
};

export type ProductPagePageable = {
  pageNumber: number;
  pageSize: number;
  sort: ProductPageSort;
  offset: number;
  paged: boolean;
  unpaged: boolean;
};

export type ProductPageSort = {
  sorted: boolean;
  empty: boolean;
  unsorted: boolean;
};
