import { api } from '@/http/api';
import { ProductPageResponse } from '@/http/response/ProductPageResponse';
import { AxiosResponse } from 'axios';

export const ProductFindAllService = async (): Promise<ProductPageResponse> => {
  const response: AxiosResponse<ProductPageResponse> = await api.get(
    `/v1/products`
  );
  return response.data;
};
