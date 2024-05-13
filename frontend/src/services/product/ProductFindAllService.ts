import { api } from '@/http/api';
import { PageResponse } from '@/http/response/PageResponse';
import { ProductDTO } from '@/http/response/ProductResponse';
import { AxiosResponse } from 'axios';

/*http://localhost:8080/api/v1/products?page=0&size=12&sort=name,ASC*/

export const ProductFindAllService = async (): Promise<
  PageResponse<ProductDTO>
> => {
  const response: AxiosResponse<PageResponse<ProductDTO>> = await api.get(
    `/v1/products?page=0&size=12&sort=id,ASC`
  );
  return response.data;
};
