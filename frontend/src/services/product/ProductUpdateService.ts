import { api } from '@/http/api';
import { ProductRequest } from '@/http/request/ProductRequest';
import { ProductResponse } from '@/http/response/ProductResponse';
import { AxiosResponse } from 'axios';

export const ProductUpdateService = async (
  request: ProductRequest
): Promise<ProductResponse> => {
  const response: AxiosResponse<ProductResponse> =
    await api.put<ProductRequest>(`/v1/products/${request.id}`, request);
  console.log('Response =>', response.data);
  return response.data;
};
