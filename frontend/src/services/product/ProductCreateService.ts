import { api } from '@/http/api';
import { ProductFiledResponse } from '@/http/response/ProductResponse';
import { AxiosResponse } from 'axios';

export const ProductCreateService = async (
  product: ProductFiledResponse
): Promise<ProductFiledResponse> => {
  const response: AxiosResponse<ProductFiledResponse> =
    await api.post<ProductFiledResponse>('/v1/products', product);
  return response.data;
};
