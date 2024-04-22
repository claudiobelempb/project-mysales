import { api } from '@/http/api';
import { ProductResponse } from '@/http/response/ProductResponse';
import { AxiosResponse } from 'axios';

export const ProductUpdateService = async (
  product: ProductResponse
): Promise<ProductResponse> => {
  const response: AxiosResponse<ProductResponse> =
    await api.put<ProductResponse>(`/v1/products/${product.id}`, product);
  return response.data;
};
