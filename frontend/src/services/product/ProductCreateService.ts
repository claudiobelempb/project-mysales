import { api } from '@/http/api';
import { ProductResponse } from '@/http/response/ProductResponse';
import { AxiosResponse } from 'axios';

export const ProductCreateService = async (
  product: ProductResponse
): Promise<ProductResponse> => {
  const response: AxiosResponse<ProductResponse> =
    await api.post<ProductResponse>('/v1/products', product);
  return response.data;
};
