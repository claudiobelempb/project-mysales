export type ProductResponse = {
  id: number;
  sku: string;
  name: string;
  price?: number;
  description: string;
  createdAt?: string;
};

export type ProductFiledResponse = {
  id?: number;
  sku: string;
  name: string;
  price?: string;
  description: string;
  createdAt?: string;
};
