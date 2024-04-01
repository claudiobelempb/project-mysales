import { api } from '@/http/api';
import { ProductRequest } from '@/http/request/ProductRequest';
import { ProductResponse } from '@/http/response/ProductResponse';
import { AxiosResponse } from 'axios';

export const ProductCreateService = async (
  request: ProductRequest
): Promise<ProductResponse> => {
  const response: AxiosResponse<ProductResponse> =
    await api.post<ProductRequest>('/v1/products', request);
  return response.data;
};
