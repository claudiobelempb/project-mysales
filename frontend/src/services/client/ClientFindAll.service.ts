import { api } from '@/http/api';
import { ClientDTO } from '@/http/response/ClientDTO';
import { PageResponse } from '@/http/response/PageResponse';
import { AxiosResponse } from 'axios';

export const ClientFindAllService = async (): Promise<
  PageResponse<ClientDTO>
> => {
  const response: AxiosResponse<PageResponse<ClientDTO>> = await api.get(
    `/v1/clients`
  );
  return response.data;
};
